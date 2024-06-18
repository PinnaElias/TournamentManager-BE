package it.manager.tournamentmanager.requests.create;

import it.manager.tournamentmanager.entities.Game;
import it.manager.tournamentmanager.entities.enums.Role;
import it.manager.tournamentmanager.entities.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequestBody {

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "username cannot be empty")
    private String username;
    @NotBlank(message = "name cannot be empty")
    private String firstName;
    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @NotBlank(message = "e-mail cannot be empty")
    @Email(message = "email does not have the right format")
    private String email;

    private List<Game> likedGames;
    private Role preferredRole;
    private String nationality;

    @NotBlank(message = "avatar url cannot be empty")
    private String avatarUrl;

    private UserRole userRole;

}