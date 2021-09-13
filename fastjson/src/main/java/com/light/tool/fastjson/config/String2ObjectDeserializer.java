package com.light.tool.fastjson.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.light.tool.fastjson.config.model.AliyunItemData;
import com.light.tool.fastjson.config.model.Response;

import java.lang.reflect.Type;

/**
 * json反序列化指定字段
 * 本例子，展示了如何通过使用拓展ObjectDeserializer来解析JSON接口中嵌套的json字符串
 * 如下结构化数据所示，Data字段的内容是一段字符串，字符串的内容为JSON接口体，如果直接转换，fast会抛出
 * syntax error, expect {, actual string, pos 658, fieldName data,，的错误
 * 通过@JsonField来指定某个字段的反序列化方式即可
 * {
 *     "deviceType": "VisionAccessNode",
 *     "identifier": "IntelligentAlarm",
 *     "iotId": "47EO88SfePZdlD9plOHi000000",
 *     "requestId": "79060",
 *     "checkFailedData": {},
 *     "name": "智能告警",
 *     "time": 1631497718867,
 *     "type": "alert",
 *     "productKey": "a1dtQQYvLiX",
 *     "deviceName": "221087893",
 *     "value": {
 *         "EventList": [
 *             {
 *                 "AlarmPicID": "TUhyYzNCNzlULUt1RlFYLV9Cd0ZBWWg4WnhGdGVwV0dGaS1DLVJFbno1QS85Nzg3MTUzOTNkNDc0NWRiYmVjN2I5MzMzYzY2ZGVjYl8xNjMxNDk3NzEzMjUz",
 *                 "EventTime": "1631497713093",
 *                 "AlarmType": 14001,
 *                 "AlarmPicSize": 434253,
 *                 "Data": "{\"LeftTopX\":0.5367,\"LeftTopY\":0.2028,\"RightBottomX\":0.5663999999999999,\"RightBottomY\":0.257,\"HeadReliability\":1.0,\"ActionType\":0,\"GenderType\":1,\"Age\":-2,\"TrackId\":37179}",
 *                 "Algorithm": "passengerStatistics",
 *                 "ProductKey": "a1M0IIblcvW",
 *                 "DeviceName": "zixingce"
 *             }
 *         ]
 *     }
 * }
 */
public class String2ObjectDeserializer implements ObjectDeserializer {
    @SuppressWarnings("unchecked")
    @Override
    public AliyunItemData deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Object parse = parser.parse(fieldName);
        return JSONObject.parseObject((String) parse, AliyunItemData.class);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    public static void main(String[] args) {
        String temp = "{\n" +
                "    \"deviceType\": \"VisionAccessNode\",\n" +
                "    \"identifier\": \"IntelligentAlarm\",\n" +
                "    \"iotId\": \"47EO88SfePZdlD9plOHi000000\",\n" +
                "    \"requestId\": \"79060\",\n" +
                "    \"checkFailedData\": {},\n" +
                "    \"name\": \"智能告警\",\n" +
                "    \"time\": 1631497718867,\n" +
                "    \"type\": \"alert\",\n" +
                "    \"productKey\": \"a1dtQQYvLiX\",\n" +
                "    \"deviceName\": \"221087893\",\n" +
                "    \"value\": {\n" +
                "        \"EventList\": [\n" +
                "            {\n" +
                "                \"AlarmPicID\": \"TUhyYzNCNzlULUt1RlFYLV9Cd0ZBWWg4WnhGdGVwV0dGaS1DLVJFbno1QS85Nzg3MTUzOTNkNDc0NWRiYmVjN2I5MzMzYzY2ZGVjYl8xNjMxNDk3NzEzMjUz\",\n" +
                "                \"EventTime\": \"1631497713093\",\n" +
                "                \"AlarmType\": 14001,\n" +
                "                \"AlarmPicSize\": 434253,\n" +
                "                \"Data\": \"{\\\"LeftTopX\\\":0.5367,\\\"LeftTopY\\\":0.2028,\\\"RightBottomX\\\":0.5663999999999999,\\\"RightBottomY\\\":0.257,\\\"HeadReliability\\\":1.0,\\\"ActionType\\\":0,\\\"GenderType\\\":1,\\\"Age\\\":-2,\\\"TrackId\\\":37179}\",\n" +
                "                \"Algorithm\": \"passengerStatistics\",\n" +
                "                \"ProductKey\": \"a1M0IIblcvW\",\n" +
                "                \"DeviceName\": \"zixingce\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        Response aliyunEventResponse = JSONObject.parseObject(temp, Response.class);
        System.out.println(aliyunEventResponse);
    }
}
