package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repositories.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        return repository.findAll();

    }

    public User findById(String id) {

		Optional<User> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

    public User insert(User obj) {

        return repository.insert(obj);

    }

    public User fromDTO(UserDTO objDto) {

        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }

}
