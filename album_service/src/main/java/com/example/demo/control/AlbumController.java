package com.example.demo.control;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AlbumEntity;
import com.example.demo.service.AlbumSer;
import com.example.demo.ui.RequestEntityModel;
import com.example.demo.ui.ResponseEntityModel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
	private final ModelMapper modelMapper;

	private final AlbumSer as;
	
	private Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}
	@PostMapping
	public ResponseEntity<ResponseEntityModel> create(@RequestBody RequestEntityModel requestmodel )
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumEntity album=as.create(requestmodel);
		ResponseEntityModel responsemodel=modelMapper.map(album,ResponseEntityModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responsemodel);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<List<ResponseEntityModel>> findByuserId(@PathVariable("userId") String userId)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<AlbumEntity> lalbum=as.findById(userId);
		List<ResponseEntityModel> lresponse=new ArrayList<>();
		for(AlbumEntity a:lalbum)
		{
			lresponse.add(modelMapper.map(a, ResponseEntityModel.class));
		}
		return ResponseEntity.status(HttpStatus.OK).body(lresponse);
	}

}
