package com.astra.astralogs.controller;


import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astra.astralogs.dto.CreateProjectDTO;
import com.astra.astralogs.dto.TesteResponse;

import lombok.RequiredArgsConstructor;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TesteController {

    private final ResourceLoader resourceLoader;

	@GetMapping("/")
	public ResponseEntity<TesteResponse> index() throws IOException {
		
		  Resource resource = resourceLoader.getResource("project.zip");

	        // Obtenha o arquivo correspondente ao recurso
	        File directory = resource.getFile();
	        
	        
		TesteResponse oTesteResponse = new TesteResponse(); 
		oTesteResponse.setData("Hello Word");
		return ResponseEntity.ok(oTesteResponse);
	}
	
	@PostMapping("/create-project")
	public ResponseEntity<TesteResponse> createProject(@org.springframework.web.bind.annotation.RequestBody CreateProjectDTO input) {
		
		String a = input.getGroupId();
		TesteResponse oTesteResponse = new TesteResponse(); 
		oTesteResponse.setData("Hello Word");
		  String apiUrl = "https://api.github.com/user/repos";
	        String token = "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"; // Substitua pelo seu token
	        String repoName = "nome-do-repositorio"; // Nome do novo repositório

	        try {
	            HttpClient client = HttpClients.createDefault();
	            HttpPost httpPost = new HttpPost(apiUrl);

	            // Configurar o cabeçalho de autorização com seu token de acesso pessoal
	            httpPost.addHeader("Authorization", "token " + token);

	            // Configurar o corpo da solicitação com o nome do repositório
	            String jsonBody = "{\"name\": \"" + repoName + "\"}";
	            StringEntity entity = new StringEntity(jsonBody);
	            httpPost.setEntity(entity);
	            httpPost.addHeader("Accept", "application/json");

	            // Enviar a solicitação para criar o repositório
	            HttpResponse response = client.execute(httpPost);

	            // Verificar a resposta
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode == 201) {
	                System.out.println("Repositório criado com sucesso!");
	            } else {
	                System.err.println("Falha ao criar o repositório. Código de resposta: " + statusCode);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return ResponseEntity.ok(oTesteResponse);
	}

}