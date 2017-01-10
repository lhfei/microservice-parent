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

package cn.lhfei.cloud.notebook.domain;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonClassDescription;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Dec 16, 2016
 */
@Document(collection = "notebooks")
@JsonAutoDetect
@JsonClassDescription
public class Notebook extends AbstractDomain {
	private static final long serialVersionUID = -6670093323586098985L;
	
	@Override
	public String toString() {
		return String.format("Notebook[id=%s, notebookId='%s', name='%s']", getId(),
				notebookId, name);
	}
	
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Map<String, Object>> getParagraphs() {
		return paragraphs;
	}
	public void setParagraphs(List<Map<String, Object>> paragraphs) {
		this.paragraphs = paragraphs;
	}
	
	private String notebookId;
	private String name;
	private List<Map<String, Object>> paragraphs;

}
