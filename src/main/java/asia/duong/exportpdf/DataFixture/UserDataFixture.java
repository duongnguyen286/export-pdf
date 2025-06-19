package asia.duong.exportpdf.DataFixture;

import asia.duong.exportpdf.entities.User;
import asia.duong.exportpdf.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class UserDataFixture {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void buildUsers() {
        if (userRepository.count() == 0) {
//            log.info("**********************AE mình cứ thế thôi, hẹ hẹ hẹ************************");
            userRepository.saveAll(
                    Arrays.asList(
                            new User(null,"Duong", "Nguyen", "duong@gmail.com"),
                            new User(null, "Dat", "Le", "dat@gmail.com"),
                            new User(null, "Vinh", "Nguyen", "vinh@gmail.com")

                    )
            );
        }
    }
}
