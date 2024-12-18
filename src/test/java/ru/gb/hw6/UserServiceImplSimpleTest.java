package ru.gb.hw6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.gb.hw6.model.User;
import ru.gb.hw6.repository.UserRepository;
import ru.gb.hw6.service.UserServiceImpl;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplSimpleTest {

    @Mock
    public UserRepository userRepository;

    @InjectMocks
    public UserServiceImpl userService;

    @Test
    public void getUserGoodTest(){
        User user = new User();
        user.setId(1L);
        user.setName("Viktor");
        user.setAge(22);
        user.setEmail("viktor@mail.com");
        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));

        userService.getUserById(1L);

        verify(userRepository).findById(1L);
    }

    @Test
    public void createUserGoodTest(){
        User user = new User();
        user.setId(2L);
        user.setName("Viktor");
        user.setAge(22);
        user.setEmail("viktor@mail.com");
        given(userRepository.save(user)).willReturn(user);

        userService.createUser(user);

        verify(userRepository).save(user);
    }
}
