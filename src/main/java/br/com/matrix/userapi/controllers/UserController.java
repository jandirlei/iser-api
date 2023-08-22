package br.com.matrix.userapi.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/")
	public String getMenssagem() {
		return "Spring boot is working!";
	}
	
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
	
/*	@PostConstruct
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
	*/
	
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
	
	@GetMapping("/{cfp}/cpf")
	public UserDTO findByCpf(String cpf) {
		return userService.findByCpf(cpf, key);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws UserNotFoundException {
		userService.delete(id);
	}
	
	@ GetMapping("/search")
	public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome){
		return userService.queryByName(nome);
	}
	
	
}
