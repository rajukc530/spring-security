package np.com.xref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import np.com.xref.dto.UserSummary;
import np.com.xref.security.CurrentUser;
import np.com.xref.security.UserPrincipal;
import np.com.xref.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;

    
    @GetMapping("me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return userService.getCurrentUser(currentUser);
    }
    
    
    @GetMapping("hello")
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentUser() {
        return "Hello";
    }

}
