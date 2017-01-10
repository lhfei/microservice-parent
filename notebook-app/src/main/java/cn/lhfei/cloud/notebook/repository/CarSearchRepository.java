package cn.lhfei.cloud.notebook.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cn.lhfei.cloud.notebook.web.model.Car;

@Repository
public class CarSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Car> searchCars(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("description").regex(text, "i"), 
									Criteria.where("make").regex(text, "i"), 
									Criteria.where("model").regex(text, "i"))
						), Car.class);
	}
	
}
