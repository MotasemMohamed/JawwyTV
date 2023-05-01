Feature: JawwyTvFeatureOtherCountries
  I want to check the price & Type and currency for each bundle

  Scenario Outline: ChooseBundleForOtherCountries
    Given The user will open the page and chooses the country logo "<countrycode>","<countryname>","<NewEssentialpackprice>","<lightpackprice>","<Essentialpackprice>","<Premiumpackprice>","<FightSport>"
    When  User will choose the essential bundle for other countries "<PaymentMethod>","<Tvjaw>","<Total_Payment>","<PhoneName>"
    Then The user will continue the cycle and add a phone number for other countries "<Tvjaw>","<Total_Payment>"


    Examples:
      |countrycode| countryname| NewEssentialpackprice| lightpackprice| Essentialpackprice |Premiumpackprice |FightSport|PaymentMethod|Tvjaw | Total_Payment| PhoneName|
      |ae         | الإمارات   | ابتداءا من 10.00 درهم إماراتي/بالاسبوع| 5.4 دولار أمريكي/شهر| 10.9 دولار أمريكي/شهر| 16.3 دولار أمريكي/شهر|متوفر|إبتداءً من: 10.00 درهم إماراتي| 10 درهم/الاسبوع | 10.00 درهم إماراتي/بالاسبوع|‫رقم الجوال|