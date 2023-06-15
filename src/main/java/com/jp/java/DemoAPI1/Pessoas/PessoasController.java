package com.jp.java.DemoAPI1.Pessoas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	private PessoasRepository pessoasRepository;

	@GetMapping
	public List<Pessoas> getAll() {
		return pessoasRepository.findAll();
	}

	@GetMapping("/{id}")
	public Pessoas getOne(@PathVariable Long id) {
		if (pessoasRepository.existsById(id)) {
			return pessoasRepository.findById(id).get();
		}
		return null;
	}

	@PostMapping
	public Pessoas post(@RequestBody Pessoas Pessoas) {
		return pessoasRepository.save(Pessoas);

	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public String delete(@PathVariable Long id) {
		if (pessoasRepository.existsById(id)) {
			pessoasRepository.deleteById(id);
			return "{\"status\" : \"deleted\"}";
		}
		return "{\"status\" : \"error\"}";
	}

	@PutMapping(path = "/{id}")
	public Pessoas put(@PathVariable Long id, @RequestBody Pessoas pessoas) {
		return null;
	}

	@PatchMapping(path = "/{id}")
	public Pessoas patch(@PathVariable Long id, @RequestBody Pessoas pessoas) {
		return null;
	}

}
