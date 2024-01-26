Feature: Trash component


	Scenario Outline: Access trash tab
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		When user clicks on log in button
		And wait for web element containing text "Trash"
		And user clicks on trash button
		Then user should be logged in on page "<loginPage>"
		And quit the driver
		Examples:
		| username           | password    | loginPage                                                        |
		| admin@codewise.com | codewise123 | https://codewiser.studymate.us/admin/deleted-items?size=6&page=1 |


	Scenario Outline: Access trash tab
		Given user navigate to log in page "https://codewiser.studymate.us/login"
		And user fill email "<username>" and password "<password>" in the login form
		When user clicks on log in button
		And wait for web element containing text "Trash"
		And user clicks on trash button
		And user clicks to "<remove_restore>" first record from trash list
		Then alert message should display "<alert>"
		And quit the driver
		Examples:
			| username           | password    | remove_restore | alert 				      |
			| admin@codewise.com | codewise123 | remove         | Data deleted successfully   |
			| admin@codewise.com | codewise123 | restore        | Data successfully recovered |

