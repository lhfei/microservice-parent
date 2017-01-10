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

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Dec 16, 2016
 */

public class AbstractDomain implements Serializable {

	private static final long serialVersionUID = 7091630934188661046L;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLatestTime() {
		return latestTime;
	}
	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}
	
	
	@Id
	private String id;
	private char status;
	private Date createTime;
	private Date latestTime;
}
