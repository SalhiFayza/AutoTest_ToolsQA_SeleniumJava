# AutoTest_ToolsQA_SeleniumJava

<h1>🪴</h1>

# How to get text without tags HTML using Selenium and Java 👊

// Locate the element that contains the message

WebElement messageElement = driver.findElement(By.id("res"));

// Get the inner HTML of the element

String innerHtml1 = messageElement.getAttribute("innerHTML");

// Remove HTML tags to extract plain text

String extractedMessage = innerHtml1.replaceAll("<.*?>", "").trim();

// Expected message

String expectedMessage = "1 file has been successfully uploaded.";

// Compare the extracted message with the expected message

Assert.assertEquals(expectedMessage, extractedMessage);

# Simple Explanation 💻
[How to get text without html tag selenium.pdf](https://github.com/SalhiFayza/APIs_Products/files/13047482/How.to.get.text.without.html.tag.selenium.pdf)

![4](https://github.com/SalhiFayza/APIs_Products/assets/60444937/690ff7b5-4d96-4919-8441-dd932c8cf654)
![7](https://github.com/SalhiFayza/APIs_Products/assets/60444937/78150198-ef69-4fbf-b669-45531d11b0a3)
![8](https://github.com/SalhiFayza/APIs_Products/assets/60444937/c666bbd8-f0d0-4cb5-8d03-fcb569394f64)

