package com.mdambro.demo.infrastructure.rest.adapter;

import com.mdambro.demo.application.adapter.input.user.UserSignUpInputAdapter;
import com.mdambro.demo.application.adapter.output.user.SaveNewUserOutputAdapter;
import com.mdambro.demo.application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdapterBeansFactory {

    private UserRepository userRepository;

    @Bean
    public UserSignUpInputAdapter getUserSignUpInputAdapter() {

        return UserSignUpInputAdapter.builder()
                .saveNewUserOutputAdapter(getSaveNewUserOutputAdapter())
                .build();

    }

    @Bean
    public SaveNewUserOutputAdapter getSaveNewUserOutputAdapter() {

        return SaveNewUserOutputAdapter.builder()
                .userRepository(userRepository)
                .build();

    }

}
