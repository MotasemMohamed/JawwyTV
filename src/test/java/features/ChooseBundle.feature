Feature: JawwyTvFeature
  I want to check the price & Type and currency for each bundle

  Scenario Outline: ChooseBundle
    Given The user will open the page and chooses the country logo "<FightSport>"
    When  User will choose the essential bundle "<TvJaw>","<orange_company>","<Other_Company>","<PhoneName>"
    Then The user will continue the cycle and add a phone number

    Examples:
      | FightSport    |TvJaw|orange_company|Other_Company|PhoneName|
      | 5.33دولار/شهر | 10 جنية مصري/الشهر|إبتداءً من: 7.00 جنيه مصري|إبتداءً من: 10.00 جنيه مصري|رقم الموبيل|
