package br.com.matrix.userapi.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.matrix.userapi.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/")
	public String getMessagem() {
		return "Spring boot is working!";
	}
	
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
	
	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome("jandir");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua das Papoulas");
		userDTO.setEmail("jandi@gmail.com.br");
		userDTO.setTelefone("9940-8621");
		userDTO.setDataCadastro(LocalDateTime.now());
		
		UserDTO userDTO2 = new UserDTO();
		userDTO.setNome("Rita");
		userDTO.setCpf("1234");
		userDTO.setEndereco("Rua das Papoulas 18");
		userDTO.setEmail("rita@gmail.com.br");
		userDTO.setTelefone("9940-8622");
		userDTO.setDataCadastro(LocalDateTime.now());
		
		UserDTO userDTO3 = new UserDTO();
		userDTO.setNome("jandirlei");
		userDTO.setCpf("12345");
		userDTO.setEndereco("Rua Martim Pereira da Silva");
		userDTO.setEmail("jandilei@gmail.com.br");
		userDTO.setTelefone("9940-4421");
		userDTO.setDataCadastro(LocalDateTime.now());
		
		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}
	
	@GetMapping
	public List<UserDTO> getUsers(){
		return usuarios;
	}
	
	@GetMapping("/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		return usuarios.stream().filter(UserDTO -> UserDTO.getCpf().equals(cpf))
				.findFirst().orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO inserir(@RequestBody @Valid UserDTO userDTO) {
		userDTO.setDataCadastro(LocalDateTime.now());
		usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/{cfp}")
	public boolean remover(@PathVariable String cpf) {
		return usuarios.removeIf(UserDTO -> UserDTO.getCpf().equals(cpf));
	}
}
