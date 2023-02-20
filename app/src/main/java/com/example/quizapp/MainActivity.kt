package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var submitBtn: Any
    lateinit var totalQuestionTextView:TextView
    lateinit var questionTextView: TextView
    lateinit var ansA:TextView
    lateinit var ansB:TextView
    lateinit var ansC:TextView
    lateinit var ansD:TextView
    var score = 0
    var totalQuestion:Int = QuestionAnswer.question.size
    var currentQuestionIndex = 0
    var selectedAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totalQuestionTextView = findViewById(R.id.total_question)
        questionTextView = findViewById(R.id.question)
        ansA = findViewById(R.id.ans_A)
        ansB = findViewById(R.id.ans_B)
        ansC = findViewById(R.id.ans_C)
        ansD = findViewById(R.id.ans_D)
        submitBtn = findViewById(R.id.submit_btn)
        ansA.setOnClickListener(this)
        ansB.setOnClickListener(this)
        ansC.setOnClickListener(this)
        ansD.setOnClickListener(this)
        (submitBtn as View?)?.setOnClickListener(this)
        totalQuestionTextView.text= "Total question : $totalQuestion"
        loadNewQuestion()
    }



    override fun onClick(view: View?) {
        ansA.setBackgroundColor(Color.WHITE)
        ansB.setBackgroundColor(Color.WHITE)
        ansC.setBackgroundColor(Color.WHITE)
        ansD.setBackgroundColor(Color.WHITE)
        ansA.setTextColor(Color.BLACK)
        ansB.setTextColor(Color.BLACK)
        ansC.setTextColor(Color.BLACK)
        ansD.setTextColor(Color.BLACK)
        val clickedButton = view as Button
        if (clickedButton.id == R.id.submit_btn) {
            if (selectedAnswer == QuestionAnswer.correctAnswer[currentQuestionIndex]) {
                score++
            }
            currentQuestionIndex++
            loadNewQuestion()
        } else {

            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.RED)
            clickedButton.setTextColor(Color.WHITE)
        }

      }
      private fun  loadNewQuestion() {
         if (currentQuestionIndex == totalQuestion){
             finishQuiz()
             return
         }
          questionTextView.text = QuestionAnswer.question[currentQuestionIndex]
          ansA.text = QuestionAnswer.choices[currentQuestionIndex][0]
          ansB.text = QuestionAnswer.choices[currentQuestionIndex][1]
          ansC.text = QuestionAnswer.choices[currentQuestionIndex][2]
          ansD.text = QuestionAnswer.choices[currentQuestionIndex][3]



      }

    private fun finishQuiz() {

    }

}

object totalQuestion {
    fun times(): String {
        TODO("Not yet implemented")
    }

}


private fun setPositiveButton(s: String, function: () -> Unit) {

}

private fun AlertDialog.Builder.setPositiveButton(s: String) {

}

