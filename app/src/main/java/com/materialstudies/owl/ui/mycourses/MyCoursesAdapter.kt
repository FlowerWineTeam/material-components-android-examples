/*
 *   Copyright (c) 2019 Google Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under the License
 *
 *   is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *   or implied. See the License for the specific language governing permissions and limitations under
 *   the License.
 */

package com.materialstudies.owl.ui.mycourses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.materialstudies.owl.R
import com.materialstudies.owl.databinding.CourseItemBinding
import com.materialstudies.owl.model.Course
import com.materialstudies.owl.model.CourseDiff
import com.materialstudies.owl.util.ShapeAppearanceTransformation

class MyCoursesAdapter : ListAdapter<Course, MyCourseViewHolder>(CourseDiff) {

    private val shapeTransform =
        ShapeAppearanceTransformation(R.style.ShapeAppearance_Owl_SmallComponent)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCourseViewHolder {
        val binding = CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyCourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyCourseViewHolder, position: Int) {
        holder.bind(getItem(position), position, shapeTransform)
    }

}

class MyCourseViewHolder(
    private val binding: CourseItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(course: Course, position: Int, imageTransform: ShapeAppearanceTransformation) {
        binding.run {
            this.course = course
            Glide.with(courseImage)
                .load("https://source.unsplash.com/collection/369966/?$position")
                .transform(imageTransform)
                .into(courseImage)
            Glide.with(courseInstructor)
                .load("https://i.pravatar.cc/56?$position")
                .circleCrop()
                .into(courseInstructor)
            executePendingBindings()
        }
    }
}
