package com.light.tool.fastjson.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.light.tool.fastjson.config.String2ObjectDeserializer;
import lombok.Data;

public @Data class EventListItem{
	private String alarmPicID;
	private String eventTime;
	private int alarmType;
	private int alarmPicSize;
	@JSONField(deserializeUsing = String2ObjectDeserializer.class)
	private AliyunItemData data;
	private String algorithm;
	private String productKey;
	private String deviceName;
}