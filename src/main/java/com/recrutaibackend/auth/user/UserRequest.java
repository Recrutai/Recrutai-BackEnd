package com.recrutaibackend.auth.user;

import com.recrutaibackend.address.CityAddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotEmpty
        @Size(max = 40)
        String firstName,

        @NotEmpty
        @Size(max = 40)
        String lastName,

        @Size(max = 150)
        String headline,

        @NotEmpty
        @Size(min = 6, max = 255)
        @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$")
        String email,

        @NotEmpty
        @Size(min = 12)
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~`!@#$%^&*()\\[\\]{}\\\\-_+=.,:;<>/|?]).{12,}$")
        String password,

        @Valid
        CityAddressRequest location
) {
}
