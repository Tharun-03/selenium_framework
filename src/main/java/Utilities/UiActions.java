package Utilities;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class UiActions {
    private static final String OBJECT_REPO_PATH = "src/test/resources/ObjectRepositories/";
    private static final Map<String, JSONObject> cache = new HashMap<>();

    private static JSONObject loadJson(String fileName){
      if(cache.containsKey(fileName)){
          return cache.get(fileName);
      }
        try {
            String content = new String(Files.readAllBytes(Paths.get(OBJECT_REPO_PATH + fileName + ".json")));
            JSONObject obj = new JSONObject(content);
            cache.put(fileName, obj);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement getElement(String fileName, String elementName) {
        JSONObject jsonObject = loadJson(fileName);
        if (jsonObject.has(elementName)) {
            JSONObject elementDetails = jsonObject.getJSONObject(elementName);
            String locatorType = elementDetails.getString("locatorType");
            String locatorValue = elementDetails.getString("locatorValue");
            return DriverFactory.getInstance().getDriver().findElement(getLocator(locatorType, locatorValue));
        }
        throw new RuntimeException("Element not found: " + elementName);
    }

    public static List<WebElement> getElements(String jsonFile, String elementName) {
        JSONObject jsonObject = loadJson(jsonFile);

        if (jsonObject.has(elementName)) {
            JSONObject elementDetails = jsonObject.getJSONObject(elementName);
            String locatorType = elementDetails.getString("locatorType");
            String locatorValue = elementDetails.getString("locatorValue");

            return DriverFactory.getInstance().getDriver().findElements(getLocator(locatorType, locatorValue));
        }
        throw new RuntimeException("Elements not found: " + elementName);
    }
    private static By getLocator(String locatorType, String locatorValue) {
        return switch (locatorType.toLowerCase()) {
            case "css" -> By.cssSelector(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "classname" -> By.className(locatorValue);
            case "tagname" -> By.tagName(locatorValue);
            case "linktext" -> By.linkText(locatorValue);
            case "partiallinktext" -> By.partialLinkText(locatorValue);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        };
    }

}
