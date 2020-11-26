/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.demo.myapp.model.impl;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Myapp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyappCacheModel implements CacheModel<Myapp>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyappCacheModel)) {
			return false;
		}

		MyappCacheModel myappCacheModel = (MyappCacheModel)obj;

		if (myappId == myappCacheModel.myappId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, myappId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{myappId=");
		sb.append(myappId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Myapp toEntityModel() {
		MyappImpl myappImpl = new MyappImpl();

		myappImpl.setMyappId(myappId);
		myappImpl.setGroupId(groupId);
		myappImpl.setCompanyId(companyId);
		myappImpl.setUserId(userId);

		if (userName == null) {
			myappImpl.setUserName("");
		}
		else {
			myappImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			myappImpl.setCreateDate(null);
		}
		else {
			myappImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			myappImpl.setModifiedDate(null);
		}
		else {
			myappImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			myappImpl.setTitle("");
		}
		else {
			myappImpl.setTitle(title);
		}

		if (description == null) {
			myappImpl.setDescription("");
		}
		else {
			myappImpl.setDescription(description);
		}

		myappImpl.setArticleId(articleId);
		myappImpl.setStatus(status);
		myappImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			myappImpl.setStatusByUserName("");
		}
		else {
			myappImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			myappImpl.setStatusDate(null);
		}
		else {
			myappImpl.setStatusDate(new Date(statusDate));
		}

		myappImpl.resetOriginalValues();

		return myappImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		myappId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		articleId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(myappId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(articleId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long myappId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long articleId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}