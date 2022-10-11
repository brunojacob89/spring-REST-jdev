package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController/*Arquitetura REST*/
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired/*Se fosse CDI sera @Inject*/
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id){
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Usuario>> usuario(){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>> (list, HttpStatus.OK);
	}
	
	
	
//	/*Serviço RESTful*/
//	@GetMapping(value = "/", produces = "application/json")
//	public ResponseEntity<?> init(@RequestParam(value = "nome",/* required = false*/ defaultValue = "Nome não informado") String nome,
//			@RequestParam(value = "salario", required = false) Long salario) {		
//		System.out.println("Recebendo " + nome + " " + salario);		
//		return new ResponseEntity<>("Olá Usuario Rest Spring Boot seu nome é: " + nome + " Salario é = " + salario, HttpStatus.OK);
//	}	
}
