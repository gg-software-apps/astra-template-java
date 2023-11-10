package com.astra.template.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astra.template.dto.TesteResponse;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TesteController {

	@GetMapping("/")
	public ResponseEntity<TesteResponse> index() throws IOException {

		TesteResponse oTesteResponse = new TesteResponse();
		oTesteResponse.setData("Hello Word");
		return ResponseEntity.ok(oTesteResponse);
	}

}