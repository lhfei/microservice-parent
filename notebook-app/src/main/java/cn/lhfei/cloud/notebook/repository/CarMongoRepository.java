package cn.lhfei.cloud.notebook.repository;

import org.springframework.data.repository.CrudRepository;

import cn.lhfei.cloud.notebook.web.model.Car;

public interface CarMongoRepository extends CrudRepository<Car, String>{}