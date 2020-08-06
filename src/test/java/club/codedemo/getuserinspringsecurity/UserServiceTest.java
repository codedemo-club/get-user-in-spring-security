package club.codedemo.getuserinspringsecurity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    /**
     * 无登录信息
     * 断言发生异常
     */
    @Test
    void getUser() {
        Assertions.assertThrows(RuntimeException.class, () ->
                this.userService.getCurrentLoginUser());
    }

    /**
     * 匿名用户登录
     */
    @Test
    @WithAnonymousUser
    void getUserWithAnonymousUser() {
        Assertions.assertEquals("anonymous",
                this.userService.getCurrentLoginUser());
    }

    @Test
    @WithMockUser
    void getUserWithUser() {
        Assertions.assertEquals("user",
                this.userService.getCurrentLoginUser());
    }
}