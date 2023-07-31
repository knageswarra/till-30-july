package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.AlbumEntity;
import com.example.demo.ui.RequestEntityModel;

import lombok.AllArgsConstructor;

@Repository
@EnableTransactionManagement
@AllArgsConstructor
public class AlbumSerImp implements AlbumSer{
    
	private final EntityManager em;
	
	private final ModelMapper modelMapper;
	@Override
	@Transactional
	public AlbumEntity create(RequestEntityModel requestmodel) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumEntity model=modelMapper.map(requestmodel,AlbumEntity.class);
		model.setAlbumId(UUID.randomUUID().toString());
	    em.persist(model);
	    return model;
	}
	@Override
	@Transactional
	public List<AlbumEntity> findById(String userId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypedQuery<AlbumEntity> query=em.createQuery("Select * from AlbumEntity A where A.userId=:ui",AlbumEntity.class);
		query.setParameter("ui",userId);
		List<AlbumEntity> l=query.getResultList();
		return l;
	}

}
