package br.com.matrix.userapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.userapi.dto.UserDTO;
import br.com.matrix.userapi.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working!";
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDTO> getUsers(){
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO newUser(@RequestBody @Valid UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@GetMapping("/{cpf}/cpf")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		userService.delete(id);
	}
	
	@GetMapping("/search")
	public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome){
		return userService.queryByName(nome);
	}
	
}
