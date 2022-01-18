package com.kseyko.sampleshopping

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.kseyko.sampleshopping.databinding.ActivityMainBinding
import com.kseyko.sampleshopping.databinding.PopupNotificationBinding


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      18,January,2022      ║
╚════════════════════════════╝
 */
class CustomDialog : DialogFragment() {
    private var _binding: PopupNotificationBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    var callbacks: OnFragmentCallbacks? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PopupNotificationBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);


        binding.okeyBtn.setOnClickListener {
            callbacks?.changeImage(true)
            dialog?.dismiss()
            Toast.makeText(
                requireContext(),
                "Your notification saved!. Thank you.",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.closeBtn.setOnClickListener {
            callbacks?.changeImage(false)
            dialog?.dismiss()
        }

        binding.selectSideBtn.setOnClickListener {
            binding.priceLayout.visibility = View.VISIBLE
        }

        binding.autoSideBtn.setOnClickListener {
            binding.priceLayout.visibility = View.GONE
        }
        binding.priceSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                // write custom code for progress is changed
                binding.priceTxt.text = seek.progress.toString() + " €"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = activity as OnFragmentCallbacks
    }

    interface OnFragmentCallbacks {
        fun changeImage(isChange: Boolean)
    }
}