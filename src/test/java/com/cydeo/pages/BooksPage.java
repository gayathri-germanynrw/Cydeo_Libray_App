package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="tbl_books_info")
    public WebElement entryCount;
}
