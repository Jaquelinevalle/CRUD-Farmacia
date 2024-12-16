package com.generation.farmacia.controller;

import java.util.List;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}	
	//Listar os produtos
	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
	}
	//Buscar produto por ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		return produtoRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	//Buscar produto por NOME
	@GetMapping("nome/{nome}")
	public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
		List<Produto> produto = produtoRepository.findByNomeContainingIgnoreCase(nome);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	@PutMapping
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	// Deletar Produto
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
	



