Feature: Login component feature


    Scenario Outline: Verify log in page with correct credentials and fake credentials
        Given user navigate to log in page "https://codewiser.studymate.us/login"
        And user fill email "<username>" and password "<password>" in the login form
        When user clicks on log in button
		Then user should be logged in on page "<loginPage>"
		And alert message should display "<alert>"
		And quit the driver
        Examples:
		| username           | password    | loginPage 										| alert 									  |
		| admin@codewise.com | codewise123 | https://codewiser.studymate.us/admin/analytics | -											  |
		| fake@codewise.com  | fakePass123 | https://codewiser.studymate.us/login			| User with email fake@codewise.com not found |
		| admin@codewise.com | fakePass123 | https://codewiser.studymate.us/login			| Invalid password						      |


	Scenario Outline: Test required email and password alert
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		When user clicks on log in button
		Then username error should match "<username_message>" and password should match "<password_message>"
		And quit the driver
		Examples:
		| username | password | username_message   | password_message      |
		| -		   | -		  | Email is required! | Password is required! |


	Scenario Outline: Verify log in page with language change
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		And user change language "<language>"
		When user clicks on log in button
		Then user should be logged in on page "<loginPage>"
		And quit the driver
		Examples:
			| username           | password    | loginPage 										| language |
			| admin@codewise.com | codewise123 | https://codewiser.studymate.us/admin/analytics | English  |
			| admin@codewise.com | codewise123 | https://codewiser.studymate.us/admin/analytics | Русский  |


	Scenario Outline: Check if language change on log in
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		And user change language "<language>"
		When user clicks on log in button
		Then check first nav link for language change, should contain "<text_in_link>"
		And quit the driver
		Examples:
			| username           | password    | text_in_link | language |
			| admin@codewise.com | codewise123 | Analytics    | English  |
			| admin@codewise.com | codewise123 | Аналитика    | Русский  |


	Scenario Outline: Test forgot password
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		When user click on forgot password link
		Given enter "<correct_incorrect>" email "<email>" to retrieve password
		When user click on submit on forgot password form
		Then user should be redirected to page "<redirect_page>"
		And alert message should display "<alert>"
		And quit the driver
		Examples:
		| email 			 | correct_incorrect | redirect_page 													| alert 									  |
		| admin@codewise.com | correct			 | https://codewiser.studymate.us/login 							| Password reset email sent to this email	  |
		| fake@codewise.com  | incorrect		 | https://codewiser.studymate.us/login?modal=FORGOT_PASSWORD_MODAL | User with email fake@codewise.com not found |


	Scenario Outline: Check forgot password must provide email
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		When user click on forgot password link
		Given enter "empty" email "-" to retrieve password
		When user gets out of input by using tab
		Then forgot password input form should have error class "<class_name>"
		And quit the driver
		Examples:
			| class_name |
			| Mui-error  |


	Scenario Outline: Change language when user is logged in
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		And user change language "<language>"
		When user clicks on log in button
		Then check first nav link for language change, should contain "<text_in_link>"
		When user change language from home page to "<switch_language>"
		Then check first nav link for language change, should contain "<switched_language>"
		And quit the driver
		Examples:
			| username           | password    | text_in_link | language | switch_language | switched_language |
			| admin@codewise.com | codewise123 | Аналитика    | Русский  | English         | Analytics 		   |
			| admin@codewise.com | codewise123 | Analytics    | English  | Русский		   | Аналитика         |


	Scenario Outline: Log user out
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		When user clicks on log in button
		And user clicks on log out button
		And user select "<confirm_cancel>" button
		Then user should be redirected to page "<redirect_to_page>"
		And quit the driver
		Examples:
			| username           | password    | confirm_cancel | redirect_to_page                               |
			| admin@codewise.com | codewise123 | Cancel         | https://codewiser.studymate.us/admin/analytics |
			| admin@codewise.com | codewise123 | Log out        | https://codewiser.studymate.us/login           |

