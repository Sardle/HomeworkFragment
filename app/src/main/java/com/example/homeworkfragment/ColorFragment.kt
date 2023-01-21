package com.example.homeworkfragment

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.view).background = getColor(arguments?.getString(KEY_COLOR))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getColor(color: String?): Drawable? {
        return when (color) {
            "Красный" -> resources.getDrawable(R.color.red)
            "Зелёный" -> resources.getDrawable(R.color.green)
            "Жёлтый" -> resources.getDrawable(R.color.yellow)
            "Синий" -> resources.getDrawable(R.color.blue)
            "Оранжевый" -> resources.getDrawable(R.color.orange)
            "Фиолетовый" -> resources.getDrawable(R.color.violet)
            else -> resources.getDrawable(R.color.purple_500)
        }
    }

    companion object {
        private const val KEY_COLOR = "color"

        fun newInstance(color: String): ColorFragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putString(KEY_COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }
}