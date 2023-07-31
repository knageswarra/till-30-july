package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AlbumEntity;
import com.example.demo.ui.RequestEntityModel;

public interface AlbumSer {
  AlbumEntity create(RequestEntityModel requestmodel);
  List<AlbumEntity> findById(String userId);
}
