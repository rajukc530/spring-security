package np.com.xref.service;

import org.springframework.stereotype.Service;

import np.com.xref.dto.UserSummary;
import np.com.xref.security.UserPrincipal;

@Service
public class UserService {

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }
}
