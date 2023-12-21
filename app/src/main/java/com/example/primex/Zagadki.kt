package com.example.primex

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.primex.databinding.ActivityZagadkiBinding

class Zagadki : AppCompatActivity() {
    val ZagadkiSpisok: List<ZagadkiList> = listOf(
        ZagadkiList(
            "Стоит дуб. В нём 12 гнёзд. В каждом гнезде по 4 яйца, в каждом яйце по 7 цыплят.",
            setOf<String>("Год", "Дом", "Неделя", "Дуб", "Колокол", "Небо")
        ),
        ZagadkiList(
            "В углу сито, не руками вито.",
            setOf<String>("Паутина", "Корзина", "Чайник", "Дом", "Колокол", "Небо")
        ),
        ZagadkiList("Кто над нами вверх ногами?", setOf<String>("Муха", "Дом", "Лиса", "Краб", "Колокол", "Небо")),
        ZagadkiList(
            "На раскрашенных страницах много праздников хранится.",
            setOf<String>("Календарь", "Дом", "Страницы", "Схрон", "Колокол", "Небо")
        ),
        ZagadkiList(
            "В лесу без огня котёл кипит.",
            setOf<String>("Муравейник", "Дом", "Чайник", "Чулан", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Шёл мужик по лесу, нёс зеркало за поясом. Лесу поклонился, лес повалился.",
            setOf<String>("Топор", "Дом", "Крот", "Тарелка", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Меня легко найдёшь зимой, но гибну я всегда весной; расту я корнем вверх — вниз головой.",
            setOf<String>("Сосулька", "Дом", "Квадрат", "Стержень", "Колокол", "Небо")
        ),
        ZagadkiList(
            "У кого глаза на рогах, а дом на спине?",
            setOf<String>("Улитка", "Дом", "Рак", "Ступень", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Бел, да не сахар. Пушист, да не птица. Нет ног, а идёт.",
            setOf<String>("Снег", "Сахар", "Дом", "Свист", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Не мотор, а гудит. Не пилот, а летит. Не змея, а жалит. Не воин, а врага валит.",
            setOf<String>("Оса", "Мёд", "Дом", "Иголка", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Дом — не дом. Из трубы — дым столбом. Весь он ходит ходуном. И качается народ взад-вперёд.",
            setOf<String>("Пароход", "Дом", "Камин", "Костёр", "Колокол", "Небо")
        ),
        ZagadkiList(
            "По сеням взад-вперёд ходит, а в избу не входит.",
            setOf<String>("Дверь", "Дом", "Окно", "Труба", "Колокол", "Небо")
        ),
        ZagadkiList("Какие животные хвойные?", setOf<String>("Ежи", "Лисы", "Змеи", "Медведи", "Окно", "Труба")),
        ZagadkiList(
            "Шарик невелик, да плакать велит.",
            setOf<String>("Лук", "Морковь", "Чеснок", "Миг", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Соль, а не солёная, фасоль, а не зелёная.",
            setOf<String>("Ноты", "Пианино", "Дом", "Сок", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Всем, кто придёт, и всем, кто уйдёт, руку подаёт.",
            setOf<String>("Ручка", "Дом", "Лиса", "Крот", "Колокол", "Небо")
        ),
        ZagadkiList("Сам верхом, а ноги за ушами.", setOf<String>("Очки", "Муравьед", "Дом", "Камин", "Колокол", "Небо")),
        ZagadkiList(
            "Ходоки на весь свет, а ног своих нет.",
            setOf<String>("Ботинки", "Волки", "Гуси", "Лисы", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Ходят великаны, горбят океаны. К берегу придут — сразу пропадут.",
            setOf<String>("Волны", "Море", "Киты", "Слоны", "Колокол", "Небо")
        ),
        ZagadkiList("Колоб-колобок забрёл на потолок.", setOf<String>("Солнце", "Заяц", "Мёд", "Пчела", "Колокол", "Небо")),
        ZagadkiList(
            "При двух руках, с одной ходит по воде. На себе носит, а не тонет.",
            setOf<String>("Лодка", "Тарелка", "Тазик", "Дом", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Две сестры качались, правды добивались. Правды добились — остановились.",
            setOf<String>("Весы", "Суд", "Пряности", "Волк", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Не бранит никто мальца, но колотят без конца. Пока он не скроется, никто не успокоится.",
            setOf<String>("Гвоздь", "Шуруп", "Младенец", "Крот", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Какой чудачок имел пятачок, его не потратил и другого не нажил?",
            setOf<String>("Поросёнок", "Телёнок", "Ягнёнок", "Дом", "Колокол", "Небо")
        ),
        ZagadkiList("Грамоты не знаю, целый век пишу.", setOf<String>("Перо", "Нож", "Крот", "Дом", "Колокол", "Небо")),
        ZagadkiList(
            "Молод был — молодцом глядел; под старость устал, меркнуть стал. Новый родится — опять развеселится.",
            setOf<String>("Месяц", "Свин", "Дом", "День", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Летит — пищит. Сядет — замолчит.",
            setOf<String>("Комар", "Молния", "Дом", "Лягушка", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Шар невелик, лениться не велит; если знаешь предмет, то покажешь весь свет.",
            setOf<String>("Глобус", "Земля", "Мяч", "Дом", "Колокол", "Небо")
        ),
        ZagadkiList(
            "А утром выйдет солнышко — и не найти ни зёрнышка!",
            setOf<String>("Звёзды", "Гвозди", "Искры", "Вафли", "Колокол", "Небо")
        ),
        ZagadkiList(
            "Вот так дом: одно окно. Каждый день в окне кино!",
            setOf<String>("Телевизор", "Театр", "Дверь", "Дом", "Колокол", "Небо")
        )
    )

    var GameList = (ZagadkiSpisok.shuffled()).take(10);
    var gameInProgress = false;
    var answeredTotal = 0;
    var answeredCorrect = 0;
    var questionAnswered = 0;


    lateinit var binding: ActivityZagadkiBinding
    private var launcher: ActivityResultLauncher<Intent>? = null;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityZagadkiBinding.inflate(layoutInflater);
        setContentView(binding.root);
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val answer = result.data?.getStringExtra("chosenAnswer")
                    var corr = "Не правильно"
                    binding.textUserAnswer.visibility = View.VISIBLE;
                    binding.textAnswerCorrectness.visibility = View.VISIBLE;
                    binding.textAnswerCorrectness.setTextColor(Color.RED)
                    if (answer == GameList[questionAnswered].answers.elementAtOrNull(0).toString()
                    ) {
                        corr = "Правильно";
                        binding.textAnswerCorrectness.setTextColor(Color.GREEN)
                        answeredCorrect++;
                    }
                    val qText = GameList[questionAnswered].riddleText;
                    questionAnswered++;
                    if (questionAnswered == 10) {
                        binding.buttonQuestion.isEnabled = false;
                        binding.buttonInfo.isEnabled = true;
                        gameInProgress = false;
                        answeredTotal += questionAnswered;
                        questionAnswered = 0;
                        binding.buttonQuestion.isEnabled = false;
                    }
                    else{ binding.buttonQuestion.isEnabled = true;}
                    binding.buttonAnswer.isEnabled = false;
                    binding.textQuest.text = qText;
                    binding.textUserAnswer.text = "Ваш ответ: " + answer;
                    binding.textAnswerCorrectness.text = corr;
                }
            }
    }

    class ZagadkiList(
        val riddleText: String,
        var answers: Set<String>
    )
    fun btnClickAnswer(view: View) {
        val intent = Intent(this, Zagadki2::class.java);
        intent.putExtra(
            "answerCorrect",
            GameList[questionAnswered].answers.elementAtOrNull(0)
        );
        intent.putExtra(
            "answer1",
            GameList[questionAnswered].answers.elementAtOrNull(1)
        );
        intent.putExtra(
            "answer2",
            GameList[questionAnswered].answers.elementAtOrNull(2)
        );
        intent.putExtra(
            "answer3",
            GameList[questionAnswered].answers.elementAtOrNull(3)
        );
        intent.putExtra(
            "answer4",
            GameList[questionAnswered].answers.elementAtOrNull(4)
        )
        intent.putExtra(
            "answer5",
            GameList[questionAnswered].answers.elementAtOrNull(5)
        );
        launcher?.launch(intent);
    }

    fun btnClickInfo(view: View) {
        val intent2 = Intent(this, Zagadki3::class.java);
        intent2.putExtra("answeredTotal", answeredTotal.toString());
        intent2.putExtra("answeredCorrect", answeredCorrect.toString());
        intent2.putExtra("answeredWrong", (answeredTotal - answeredCorrect).toString());
        startActivity(intent2);
    }

    fun btnClickNext(view: View) {
        binding.textUserAnswer.visibility = View.GONE;
        binding.textAnswerCorrectness.visibility = View.GONE;
        binding.buttonQuestion.isEnabled = false;
        if (gameInProgress) {
            binding.textQuest.text = GameList[questionAnswered].riddleText
            binding.textView.text = "Вопрос № " + (questionAnswered + 1)
            binding.buttonAnswer.isEnabled = true
            binding.buttonQuestion.isEnabled = false
            binding.buttonQuestion.text = "Загадка"

        } else {
            GameList = (ZagadkiSpisok.shuffled()).take(10)
            binding.textQuest.text = GameList[questionAnswered].riddleText
            binding.buttonAnswer.isEnabled = true
            binding.buttonInfo.isEnabled = false
            gameInProgress = true
            binding.textView.text = "Вопрос № 1"
            questionAnswered = 0
            answeredCorrect = 0
        }
    }



}
