package com.astra.template.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astra.template.dto.ExampleDTO;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ExampleController {

	@GetMapping("/")
	public ResponseEntity<ExampleDTO> index() throws IOException {

		ExampleDTO oTesteResponse = new ExampleDTO();
		oTesteResponse.setData("Hello Word");
		return ResponseEntity.ok(oTesteResponse);
	}

}