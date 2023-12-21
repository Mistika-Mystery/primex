package com.example.primex

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.primex.databinding.ActivitySecondBinding

class Second : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    private  var launcher: ActivityResultLauncher<Intent>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val answer = result.data?.getStringExtra("answerUser")
                    var correctness = "Пправильный ответ"
                    binding.TxtCorrectness.setTextColor(Color.GREEN)
                    if (answer != TextAnswer(rnd)) {
                        correctness = "Неравильный ответ"
                        binding.TxtCorrectness.setTextColor(Color.RED)
                        rightNumberAnswer++
                    }
                    count++
                    if (count == 10)
                    {
                        binding.StaticBtn.setEnabled(true)
                        list = (0..29).toMutableList()
                        progress = false
                        total += count
                        count = 0
                        binding.MysteryBtn.text = "Начать сначала"
                        binding.TxtMystery.text = "Игра закончена"
                    }
                    binding.MysteryBtn.setEnabled(true)
                    binding.AnswerBtn.setEnabled(false)
                    binding.TxtAnswer.text = "Ваш ответ - " + answer
                    binding.TxtCorrectness.text = correctness
                }
            }
    }

    fun TextAnswer(rnd:Int):String {
        var arr = arrayOf("Санки","Снег","Морковь","Снежинка","Волк","Замок","Капуста","Лук","Кабачки","Зеркало","Гвоздь","Ёлка",
            "Гроза","Лиса","Гусь","Арбуз","Ландыш","Акула","Муравьи","Крокодил","Собака","Петух","Дятел","Барабан","Мяч","Крапива",
            "Велосипед","Утюг","Холодильник","Батарея отопления")
        var returntxt = arr[rnd]
        return returntxt
    }

    fun TextMystery(rnd:Int):String {
        var arr = arrayOf("Под гору — коняшка, в гору — деревяшка.",
            "На деревья, на кусты с неба падают цветы. Белые, пушистые, только не душистые.",
            "Сидит в темнице, красная девица, а коса на улице.",
            "Зимой — звезда, весной — вода.",
            "Кто зимой холодной ходит злой, голодный?",
            "Не лает, не кусает, а в дом не пускает.",
            "Сто одёжек и все без застежек.",
            "Сидит дед, в шубу одет, кто его раздевает, тот слёзы проливает.",
            "Белые поросятки прилегли на грядке.",
            "И сияет, и блестит, никому оно не льстит.",
            "В доску спрячется бедняжка — чуть видна его фуражка.",
            "Зимой и летом одним цветом.",
            "Сперва блеск, за блеском — треск!",
            "Рыжая плутовка, хитрая да ловкая, в сарай попала, кур пересчитала.",
            "По лужку он важно бродит, из воды сухим выходит, носит красные ботинки, дарит мягкие перинки.",
            "К нам приехали с бахчи полосатые мячи.",
            "Белые горошки на зелёной ножке.",
            "Зубы в пасти в три ряда. Это целая беда. Этот хищник знаменит, тем, что он — морской бандит.",
            "Мы — лесные жители, мудрые строители. Из иголок всей артелью строим дом себе под елью.",
            "По реке плывет бревно. Ох, и злющее оно!",
            "аворчал живой замок, лег у двери поперек. Две медали на груди. Лучше в дом не заходи!",
            "Всех я вовремя бужу, хоть часов не завожу.",
            "Все время стучит, деревья долбит. Но их не калечит, а только лечит.",
            "Сам пустой, голос густой, дробь отбивает, шагать и петь помогает.",
            "Упадет — поскачет, ударишь — не плачет.",
            "Ах, не трогайте меня: обожгу и без огня!",
            "Этот конь не ест овса, вместо ног — два колеса. Сядь верхом и мчись на нём, только лучше правь рулём.",
            "То назад, то вперед, ходит, бродит пароход. Остановишь — горе! Продырявит море!",
            "Полюбуйся, посмотри — полюс северный внутри! Там сверкает снег и лед, там сама зима живет.",
            "В нашем доме под окошком есть горячая гармошка: не поет и не играет — она дом обогревает.")
        var returntxt = arr[rnd]
        return returntxt
    }

    var count=0
    var total = 0
    var list = (0..29).toMutableList()
    var progress = false
    var rnd = 0
    var question = ""
    var rightNumberAnswer = 0
    val answerIntent = Intent(this, Second2::class.java)
    val staticIntent = Intent(this,Second3::class.java)


    fun onClickMystery(view: View) {
        if (progress)
        {
            binding.AnswerBtn.setEnabled(true)
            binding.MysteryBtn.setEnabled(false)
            rnd = list.random()
            list.removeAt(rnd)
            binding.NumMystery.text = "Вопрос №" + (1 + count).toString()
            question = TextMystery(rnd)
            binding.TxtMystery.text= question
        }
        else
        {
            progress = true
            rnd = list.random()
            list.removeAt(rnd)
            binding.NumMystery.text = "Вопрос №1"
            question = TextMystery(rnd)
            binding.TxtMystery.text= question
            binding.AnswerBtn.setEnabled(true)
            binding.MysteryBtn.setEnabled(false)
        }
    }

    fun onClickAnswer(view:View) {
        answerIntent.putExtra("question",question)
        launcher?.launch(answerIntent)
    }
    fun onClickStatic(view:View) {
        staticIntent.putExtra("rightNumberAnswer",rightNumberAnswer)
        staticIntent.putExtra("wrongNumberAnswer",total - rightNumberAnswer)
        startActivity(staticIntent)
    }
}
