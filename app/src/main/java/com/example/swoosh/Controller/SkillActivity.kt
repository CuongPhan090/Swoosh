package com.example.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.EXTRA_LEAGUE
import com.example.swoosh.EXTRA_SKILL
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var selectedLeague = ""
    var selectedSkill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        selectedLeague = intent.getStringExtra(EXTRA_LEAGUE).toString()

        tbSkillBaller.setOnClickListener{
            tbSkillBeginner.isChecked = false
            selectedSkill = "Baller"
        }

        tbSkillBeginner.setOnClickListener{
            tbSkillBaller.isChecked = false
            selectedSkill = "Beginner"
        }

        btnSkillFinish.setOnClickListener{
            if (tbSkillBaller.isChecked || tbSkillBeginner.isChecked) {
                val skillIntent = Intent(this, FinishActivity::class.java)
                skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
                skillIntent.putExtra(EXTRA_SKILL, selectedSkill)
                startActivity(skillIntent)
            }
            else {
                Toast.makeText(this, "Please select your skill!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}