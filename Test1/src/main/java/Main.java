import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.ryanair.com/gb/en");

        driver.manage().window().maximize();

        try
        {
            WebElement CookiesPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("/html/body/div/div/div[3]/button[3]")));

            if (CookiesPopUp.isDisplayed())
            {
                CookiesPopUp.click();

                System.out.println("Coockies Accepted");
            }

            //Selecionar o local de chegada
            WebElement toInput = driver.findElement(By.id("input-button__destination"));
            toInput.sendKeys("Paris");
            toInput.sendKeys(Keys.TAB);

            /*
            No PDF fornecido para o desenvolvimento do teste é pedido que seja selecionada a data de 06-06-2021,
            no entanto como esta data já não está disponovel optei por selecionar a data de 01-10-2024
            O mesmo se aplica à data de chegada,
            como a data 30-10-2021 já não está disponivel optei por definir como 25-10-2024
            */


            String xpath_start="/html/body/ry-tooltip[1]/div[2]/hp-app-controls-tooltips/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-flexible-datepicker-container/fsw-datepicker/ry-datepicker-desktop/div/calendar[2]/calendar-body/div[3]/div[10]/div";
            WebElement xpath_departure = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(xpath_start)));
            xpath_departure.click();

            System.out.println("Start date selected...");


            String xpath_end="/html/body/ry-tooltip/div[2]/hp-app-controls-tooltips/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-flexible-datepicker-container/fsw-datepicker/ry-datepicker-desktop/div/calendar[2]/calendar-body/div[5]/div[13]/div";
            WebElement xpath_arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(xpath_end)));
            xpath_arrival.click();

            System.out.println("End date selected...");


            String add_adult_xpath = "/html/body/ry-tooltip/div[2]/ry-passengers-container/ry-passengers/ry-passengers-picker-container/ry-passengers-picker/ry-counter[1]/div[2]/div[3]";
            WebElement add_adult = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(add_adult_xpath)));
            add_adult.click();

            String add_child_xpath = "/html/body/ry-tooltip/div[2]/ry-passengers-container/ry-passengers/ry-passengers-picker-container/ry-passengers-picker/ry-counter[3]/div[2]/div[3]";
            WebElement add_child = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(add_child_xpath)));
            add_child.click();

            System.out.println("passengers added...");

            String search_btn_xpath = "/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/div/hp-flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/fsw-flight-search-widget-content-container/fsw-flight-search-widget-content/div[2]/div[2]/button";
            WebElement search_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(search_btn_xpath)));
            search_btn.click();

            /*
            String flight_first_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/ry-spinner/div/flight-card-new/div/div/div[4]/flight-card-summary/div[2]/button";
            WebElement flight_first = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(flight_first_xpath)));
            flight_first.click();

            String flight_second_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/ry-spinner/div/flight-card-new[1]/div/div/div[4]/flight-card-summary/div[2]/button";
            WebElement flight_second = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(flight_second_xpath)));
            flight_second.click();
             */

            String edit_btn_xpath = "/html/body/app-root/flights-root/div/div/flights-trip-details-container/flights-trip-details/div/div[1]/button";
            WebElement edit_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(edit_btn_xpath)));
            edit_btn.click();

            System.out.println("Selecting new departure date...");

            String departure_edit_input_xpath = "/html/body/app-root/flights-root/div/div/flights-trip-details-container/flights-trip-details/div/div[2]/ng-component/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/fsw-flight-search-widget-controls/div[1]/div[2]/div/fsw-input-button[1]";
            WebElement departure_edit_input = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(departure_edit_input_xpath)));
            departure_edit_input.click();

            String new_mount_xpath = "/html/body/ry-tooltip/div[2]/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-datepicker-container/fsw-datepicker/ry-datepicker-desktop/month-toggle/div/div[2]/div/div[4]/div[2]";
            WebElement new_mount = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_mount_xpath)));
            new_mount.click();

            String new_departure_date_xpath = "/html/body/ry-tooltip/div[2]/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-datepicker-container/fsw-datepicker/ry-datepicker-desktop/div/calendar[1]/calendar-body/div[3]/div[13]/div";
            WebElement new_departure_date = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_departure_date_xpath)));
            new_departure_date.click();

            System.out.println("New departure date selected...");
            System.out.println("Selecting new arrival date...");

            String new_arrival_date_xpath = "/html/body/ry-tooltip/div[2]/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-datepicker-container/fsw-datepicker/ry-datepicker-desktop/div/calendar[1]/calendar-body/div[4]/div[10]/div";
            WebElement new_arrival_date = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_arrival_date_xpath)));
            new_arrival_date.click();

            System.out.println("New arrival date selected...");

            String new_search_btn_xpath = "/html/body/app-root/flights-root/div/div/flights-trip-details-container/flights-trip-details/div/div[2]/ng-component/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/fsw-flight-search-widget-controls/div[2]/div/button";
            WebElement new_search_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_search_btn_xpath)));
            new_search_btn.click();

            String new_departure_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/ry-spinner/div/flight-card-new/div/div/div[4]/flight-card-summary/div[2]/button";
            WebElement new_departure = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_departure_xpath)));
            new_departure.click();

            String new_arrival_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/ry-spinner/div/flight-card-new[1]/div/div/div[4]/flight-card-summary/div[2]/button";
            WebElement new_arrival = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(new_arrival_xpath)));
            new_arrival.click();

            System.out.println("Tickets selected...");

            String service_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/fare-selector-container/fare-selector/div/fare-table-new-layout-container/fare-table-new-layout/table/thead/tr/th[3]/div";
            WebElement service = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(service_xpath)));
            service.click();

            String login_later_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/ry-login-touchpoint-container/ry-login-touchpoint/div/button";
            WebElement login_later = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(login_later_xpath)));
            login_later.click();

            String passenger1_title_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button";
            String passenger1_fname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[1]/div/input";
            String passenger1_lname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[2]/div/input";

            System.out.println("Filling passenger info...");

            WebElement passenger1_title = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger1_title_xpath)));
            WebElement passenger1_fname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger1_fname_xpath)));
            WebElement passenger1_lname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger1_lname_xpath)));

            passenger1_title.click();

            String passenger1_title_option_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/div/div/ry-dropdown-item[3]/button";
            WebElement passenger1_title_option = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger1_title_option_xpath)));

            passenger1_title_option.click();

            passenger1_fname.sendKeys("Sónia");
            passenger1_lname.sendKeys("Pereira");

            System.out.println("Passenger 1 filled...");


            String passenger2_title_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button";
            String passenger2_fname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[1]/div/input";
            String passenger2_lname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[2]/div/input";

            System.out.println("Filling passenger info...");

            WebElement passenger2_title = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger2_title_xpath)));
            WebElement passenger2_fname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger2_fname_xpath)));
            WebElement passenger2_lname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger2_lname_xpath)));

            passenger2_title.click();

            String passenger2_title_option_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/div/div/ry-dropdown-item[1]/button";
            WebElement passenger2_title_option = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger2_title_option_xpath)));

            passenger2_title_option.click();

            passenger2_fname.sendKeys("Diogo");
            passenger2_lname.sendKeys("Pereira");

            System.out.println("Passenger 2 filled...");

            String passenger3_fname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[3]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[1]/div/input";
            String passenger3_lname_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[3]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-input-d[2]/div/input";

            WebElement passenger3_fname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger3_fname_xpath)));
            WebElement passenger3_lname = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(passenger3_lname_xpath)));

            passenger3_fname.sendKeys("Inês");
            passenger3_lname.sendKeys("Marçal");

            System.out.println("Passenger 3 filled...");

            String continue_btn_xpath = "/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/ng-component/div/continue-flow-container/continue-flow/div/div/span/button";
            WebElement continue_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(continue_btn_xpath)));
            continue_btn.click();

            String seat_popup_xpath = "/html/body/seats-root/ry-portal/div/ng-component/ry-dialog/div[2]/div[2]/div[2]/button";
            WebElement seat_popup = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(seat_popup_xpath)));

            if(seat_popup.isDisplayed())
            {
                seat_popup.click();
            }

            System.out.println("Selecting seats...");

            String seat1_xpath = "/html/body/seats-root/div/div/div[2]/ng-component/seats-container-v2/main/div[2]/div/div/div/div/div[2]/div[2]/seat-map/div/div[5]/div/div[1]/button";
            WebElement seat1 = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(seat1_xpath)));
            seat1.click();

            String seat2_xpath = "/html/body/seats-root/div/div/div[2]/ng-component/seats-container-v2/main/div[2]/div/div/div/div/div[2]/div[2]/seat-map/div/div[5]/div/div[2]/button";
            WebElement seat2 = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(seat2_xpath)));
            seat2.click();

            String seat3_xpath = "/html/body/seats-root/div/div/div[2]/ng-component/seats-container-v2/main/div[2]/div/div/div/div/div[2]/div[2]/seat-map/div/div[5]/div/div[3]/button";
            WebElement seat3 = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(seat3_xpath)));
            seat3.click();

            System.out.println("Departure seats selected...");

            String next_flight_btn_xpath = "/html/body/seats-root/div/div/div[2]/ng-component/seats-container-v2/main/div[2]/div/div/div/div/div[2]/div[3]/div/passenger-carousel/div[2]/button";
            WebElement next_flight_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(next_flight_btn_xpath)));
            next_flight_btn.click();

            System.out.println("Next flight...");

            String same_seats_xpath = "/html/body/seats-root/div/div/div[2]/ng-component/seats-container-v2/main/div[2]/div/div/div/div/div[2]/div[2]/div/seats-offer/ry-action-sheet/div/div/div[1]/div/div[2]/button[2]";
            WebElement same_seats = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(same_seats_xpath)));
            same_seats.click();

            System.out.println("Same seats selected...");

            String fast_track_xpath = "/html/body/seats-root/div/personalization-takeovers/ry-message-renderer[2]/ng-component/ry-enhanced-takeover-beta-desktop/div/div[3]/div[2]/div[1]/button";
            WebElement fast_track = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(fast_track_xpath)));
            fast_track.click();

            System.out.println("No fast track...");

            String continue2_btn_xpath = "/html/body/bags-root/bags-booking-container/div/main/div/section[4]/bags-continue-flow-container/bags-continue-flow/button";
            WebElement continue2_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(continue2_btn_xpath)));
            continue2_btn.click();

            System.out.println("Next step...");

            String noThanks_xpath = "/html/body/app-root/ng-component/div/div/div/main/div/personalization-takeovers/ry-message-renderer[4]/ng-component/ry-enhanced-takeover-desktop/div/div[3]/button[2]";
            WebElement noThanks = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(noThanks_xpath)));
            noThanks.click();

            System.out.println("Next step...");

            String continue3_btn_xpath = "/html/body/app-root/ng-component/div/div/div/main/div/airport-and-flight-container/button";
            WebElement continue3_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(continue3_btn_xpath)));
            continue3_btn.click();

            System.out.println("Next step...");

            String continue4_btn_xpath = "/html/body/app-root/ng-component/div/div/div/main/div/ng-component/button";
            WebElement continue4_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(continue4_btn_xpath)));
            continue4_btn.click();

            System.out.println("Next step...");

            String please_login_xpath = "/html/body/app-root/div/kyc-login/kyc-common-wrapper";
            WebElement please_login = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(please_login_xpath)));
            please_login.click();

            System.out.println("Test execution finished with no errors...");
        }
        finally
        {
            driver.quit();
        }
    }
}
