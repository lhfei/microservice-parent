/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.cloud.notebook.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cn.lhfei.cloud.notebook.domain.Notebook;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Dec 16, 2016
 */
@RepositoryRestResource(collectionResourceRel = "notebooks", path = "notebooks")
public interface NotebookRepository extends MongoRepository<Notebook, String> {
	
	List<Notebook> findByName(String name);
}
