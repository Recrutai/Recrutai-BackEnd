package com.recrutai.api.profile.course;

import com.recrutai.api.auth.user.UserService;
import com.recrutai.api.organization.school.School;
import com.recrutai.api.organization.school.SchoolService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final UserService userService;
    private final SchoolService schoolService;

    public CourseService(
            CourseRepository courseRepository,
            CourseMapper courseMapper,
            UserService userService,
            SchoolService schoolService
    ) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.userService = userService;
        this.schoolService = schoolService;
    }

    @Transactional
    public CourseResponse create(long userId, CourseRequest request) {
        var user = userService.findById(userId);
        var school = getSchool(request);

        var course = courseMapper.mapToEntity(request, user, school);
        courseRepository.save(course);

        return courseMapper.mapToResponse(course);
    }

    private School getSchool(CourseRequest request) {
        if (request.getSchoolId() != null) {
            return schoolService.findById(request.getSchoolId());
        }
        if (request.getFallbackSchoolName() == null) {
            var msg = "The school's name is required when the id of an existing one is not provided";
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, msg);
        }
        return null;
    }

    public List<CourseResponse> findAllByUsersId(long id) {
        return courseRepository.findAllByUserId(id)
                .stream()
                .map(courseMapper::mapToResponse)
                .toList();
    }

    public void delete(long id) {
        var course = this.findById(id);
        courseRepository.delete(course);
    }

    public Course findById(long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

}
