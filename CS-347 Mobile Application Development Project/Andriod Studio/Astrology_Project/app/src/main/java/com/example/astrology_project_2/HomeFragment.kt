package com.example.astrology_project_2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        done_button.setOnClickListener {

            var userYear = yearInt.text.toString().toIntOrNull()
            var userMonth = monthInt.text.toString().toIntOrNull()
            var userDay = dayInt.text.toString().toIntOrNull()

            var action =
            if(userYear == null || userMonth == null || userDay == null)
                 HomeFragmentDirections.actionHomeFragmentToResultFragment()
            else
            {
                // Start of year horoscope
                var yearStr = when (userYear % 12)
                {
                    0 -> "Monkey"
                    1 -> "Rooster"
                    2 -> "Dog"
                    3 -> "Pig"
                    4 -> "Rat"
                    5 -> "Oz"
                    6 -> "Tiger"
                    7 -> "Rabbit"
                    8 -> "Dragon"
                    9 -> "Snake"
                    10 -> "Horse"
                    12 -> "Ram"
                    else -> "Unknown output. Please try again."

                }
                // End of year horoscope

                // Start of month zodiac
                var monthStr: String?
                if (userMonth == 1)
                {
                    if (userDay < 20)
                        monthStr = "Capricorn";
                    else
                        monthStr = "Aquarius";
                }
                else if (userMonth == 2)
                {
                    if (userDay < 19)
                        monthStr = "Aquarius";
                    else
                        monthStr = "Pisces";
                }
                else if(userMonth == 3)
                {
                    if (userDay < 21)
                        monthStr = "Pisces";
                    else
                        monthStr = "Aries";
                }
                else if (userMonth == 4)
                {
                    if (userDay < 20)
                        monthStr = "Aries";
                    else
                        monthStr = "Taurus";
                }
                else if (userMonth == 5)
                {
                    if (userDay < 21)
                        monthStr = "Taurus";
                    else
                        monthStr = "Gemini";
                }
                else if(userMonth == 6)
                {
                    if (userDay < 21)
                        monthStr = "Gemini";
                    else
                        monthStr = "Cancer";
                }
                else if (userMonth == 7)
                {
                    if (userDay < 23)
                        monthStr = "Cancer";
                    else
                        monthStr = "Leo";
                }
                else if(userMonth == 8)
                {
                    if (userDay < 23)
                        monthStr = "Leo";
                    else
                        monthStr = "Virgo";
                }
                else if (userMonth == 9)
                {
                    if (userDay < 23)
                        monthStr = "Virgo";
                    else
                        monthStr = "Libra";
                }
                else if (userMonth == 10)
                {
                    if (userDay < 23)
                        monthStr = "Libra";
                    else
                        monthStr = "Scorpio";
                }
                else if (userMonth == 11)
                {
                    if (userDay < 22)
                        monthStr = "Scorpio";
                    else
                        monthStr = "Sagittarius";
                }
                else if (userMonth == 12)
                {
                    if (userDay < 22)
                        monthStr = "Sagittarius";
                    else
                        monthStr ="Capricorn";
                }
                else
                {
                    monthStr = "Unknown output. Please try again.";
                }
                // End of month zodiac

                // Start of numerology
                var numValue: Int = 0;
                var tempNumValue: Int;

                var tempYear: Int = userYear;
                var tempMonth: Int = userMonth;
                var tempDay: Int = userDay;


                var count: Int = 4;
                while(count > 0)
                {
                    numValue += tempYear % 10;
                    tempYear /= 10;
                    count--;
                }

                if(userMonth < 9)
                {
                    count = 2
                    while(count > 0)
                    {
                        numValue += tempMonth % 10;
                        tempMonth /= 10;
                        count--;
                    }
                }
                else
                    numValue += tempMonth;

                if(userDay < 9)
                {
                    count = 2
                    while(count > 0)
                    {
                        numValue += tempDay % 10;
                        tempDay /= 10;
                        count--;
                    }
                }
                else
                    numValue += tempDay;

                tempNumValue = numValue;
                println(tempNumValue);

                if(tempNumValue > 9)
                {
                    count = 2
                    numValue = 0;
                    while(count > 0)
                    {
                        numValue += tempNumValue % 10;
                        tempNumValue /= 10;
                        count--;
                    }
                }
                else
                    numValue = numValue;

                println(numValue);

                tempNumValue = numValue;
                println(tempNumValue);

                if(tempNumValue > 9)
                {
                    count = 2
                    numValue = 0;
                    while(count > 0)
                    {
                        numValue += tempNumValue % 10;
                        tempNumValue /= 10;
                        count--;
                    }
                }
                else
                    numValue = numValue;
                // End of numerology

                var finalYear: String = yearStr.toString()
                var finalMonth: String = monthStr.toString()
                var finalNumValue: String = numValue.toString()

                var sendStr: String = "Horoscope: $finalYear  \n \n Zodiac: $finalMonth \n \n Numerology: $finalNumValue "



                 HomeFragmentDirections.actionHomeFragmentToResultFragment("$sendStr")

            }
            it.findNavController().navigate(action)
        }
    }
}
