package club.codedemo.getuserinspringsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

/**
 * 获取当前登录用户
 * @return
 */
String getCurrentLoginUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null) {
        throw new RuntimeException("当前无用户登录");
    } else {
        logger.info(authentication.getName());
        return authentication.getName();
    }
}
}
