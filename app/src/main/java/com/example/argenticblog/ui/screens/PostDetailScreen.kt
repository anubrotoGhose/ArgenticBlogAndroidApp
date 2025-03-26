package com.example.argenticblog.ui.screens

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.text.method.LinkMovementMethod
import android.transition.Transition
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.example.argenticblog.model.Post

@Composable
fun PostDetailScreen(post: Post, onBack: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = onBack) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = post.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "By ${post.author} - ${post.date}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary
        )
//        Text(
//            text = post.date,
//            fontSize = 10.sp,
//            color = MaterialTheme.colorScheme.onBackground
//        )
        Spacer(modifier = Modifier.height(8.dp))

//        Text(
//            text = post.content,
//            fontSize = 16.sp,
//            color = MaterialTheme.colorScheme.onSurface
//        )

        Spacer(modifier = Modifier.height(8.dp))

        HtmlTextView(htmlContent = post.content)
    }
}

@Composable
fun HtmlTextView(htmlContent: String) {
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                textSize = 16f
                movementMethod = LinkMovementMethod.getInstance() // Enable clickable links
                setText(HtmlCompat.fromHtml(htmlContent, HtmlCompat.FROM_HTML_MODE_LEGACY))
            }
        },
        update = { textView ->
            textView.setText(HtmlCompat.fromHtml(htmlContent, HtmlCompat.FROM_HTML_MODE_LEGACY))
        }
    )
}

//class GlideImageGetter(val textView: TextView, val context: Context) : Html.ImageGetter {
//    override fun getDrawable(source: String?): Drawable {
//        val drawable = ColorDrawable(Color.LTGRAY) // Placeholder while image loads
//        Glide.with(context)
//            .asDrawable()
//            .load(source)
//            .into(object : CustomTarget<Drawable>() {
//                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
//                    resource.setBounds(0, 0, resource.intrinsicWidth, resource.intrinsicHeight)
//                    drawable.setBounds(0, 0, resource.intrinsicWidth, resource.intrinsicHeight)
//                    drawable.drawable = resource
//                    textView.text = textView.text // Refresh TextView to show image
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {}
//            })
//        return drawable
//    }
//}


