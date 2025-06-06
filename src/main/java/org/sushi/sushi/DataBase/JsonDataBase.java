package org.sushi.sushi.DataBase;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JsonDataBase {
    private final File file;
    private final Gson gson;
    private final Map<String, Object> data;

    public JsonDataBase(File file) {
        this.file = file;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.data = new HashMap<>();
        load();
    }
    public boolean has(String key) {
        return data.containsKey(key);
    }
    // 값 설정
    public void set(String key, Object value) {
        data.put(key, value);
        save();
    }

    // 값 가져오기 (Object 형태)
    public Object get(String key) {
        return data.get(key);
    }


    // 값 삭제
    public void remove(String key) {
        data.remove(key);
        save();
    }

    // 전체 Map 가져오기
    public Map<String, Object> getAll() {
        return Collections.unmodifiableMap(data);
    }

    // 저장
    public void save() {
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 불러오기
    public void load() {
        if (!file.exists()) return;
        try (Reader reader = new FileReader(file)) {
            JsonElement element = JsonParser.parseReader(reader);
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                data.clear();
                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    data.put(entry.getKey(), parseJsonElement(entry.getValue()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // JsonElement를 Java 객체로 파싱
    private Object parseJsonElement(JsonElement el) {
        if (el.isJsonPrimitive()) {
            JsonPrimitive prim = el.getAsJsonPrimitive();
            if (prim.isBoolean()) return prim.getAsBoolean();
            if (prim.isNumber()) return prim.getAsNumber();
            if (prim.isString()) return prim.getAsString();
        } else if (el.isJsonObject()) {
            Map<String, Object> obj = new HashMap<>();
            for (Map.Entry<String, JsonElement> e : el.getAsJsonObject().entrySet()) {
                obj.put(e.getKey(), parseJsonElement(e.getValue()));
            }
            return obj;
        } else if (el.isJsonArray()) {
            List<Object> list = new ArrayList<>();
            for (JsonElement e : el.getAsJsonArray()) {
                list.add(parseJsonElement(e));
            }
            return list;
        }
        return null;
    }
}