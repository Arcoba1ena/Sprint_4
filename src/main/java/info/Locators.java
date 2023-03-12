package info;

public abstract class Locators {

    /**Кейс-1 "Заказ самоката"
     [button] (Кнопка "Заказать" в правом верхнем углу)
     @param "headerOrderBtn"
     @class='Button_Button__ra12g'


     [input] "Имя"
     @param "name"
     @xpath ".//input[@placeholder='* Имя']"


     [input] "Фамилия"
     @param "surname"
     @xpath ".//input[@placeholder='* Фамилия']"


     [input] "Адрес"
     @param "address"
     @xpath ".//input[@placeholder='* Адрес: куда привезти заказ']"


     [input] "Станция метро"
     @param "stationName"
     @xpath ".//input[@placeholder='* Станция метро']"


     [ul.li] "Выбор станции метро"
     @param "stationValue"
     @xpath ".//div[@class='select-search__select']/ul/li[%s]"


     [input] "Телефон"
     @param "phoneNumber"
     @xpath ".//input[@placeholder='* Телефон: на него позвонит курьер']"


     [button] "Далее"
     @param "continueBtn"
     @xpath ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"


     [input] "Когда привезти самокат"
     @param "calendar"
     @xpath ".//input[@placeholder='* Когда привезти самокат']"


     [div] "Кнопка выбора дня в календаре"
     @param "calendarBtn"
     @xpath ".//div[@aria-label='Choose %s']"  к примеру ("суббота, 18-е марта 2023 г.")


     [div] "Срок аренды"
     @param "rentalPeriod"
     @class='Dropdown-placeholder'


     [div] "Выбор периода"
     @param "rentalPeriodBtn"
     @xpath ".//div[@class='Dropdown-option'][%s]"


     [input] "Выбора цвета самоката"
     @param "scooterColour"
     @class='Order_Checkboxes__3lWSI'


     [checkBox] "Цвет"
     @param "checkBoxColour"
     @id='black'
     @id='grey'


     [input] "Комментарий"
     @param "comment"
     @class='Input_Input__1iN_Z Input_Responsible__1jDKN'


     [button] "Заказать в форме аренды самоката"
     @param "rentalOrderBtn"
     @class='Button_Button__ra12g Button_Middle__1CSJM']


     [button] "Кнопка 'Да' в появляющейся форме заказа"
     @param "accept"
     @xpath ".//button[contains(text(),'Да')]"


     [button] "Кнопка 'Нет' в появляющейся форме заказа"
     @param "cancel"
     @xpath ".//button[contains(text(),'Нет')]"

     [div] "Форма оформленного заказа"
     @param "orderSuccess"
     @xpath ".//div[contains(text(),'Заказ оформлен')]"
     */



    /**Кейс-2 "Выпадающий список в разделе «Вопросы о важном»"
     [div]
     @param "accordionBtn"
     @id "accordion__heading-{%s}"

     [p]
     @param "accordionTxt"
     @xpath ".//*[@id='accordion__panel-{%s}']/p"
     */
}