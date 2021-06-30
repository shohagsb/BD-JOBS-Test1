package me.shohag.bdjobstest1.model

data class JobResponse(
    val statuscode: String,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val jobTitle: String,
        val deadline: String,
        val jobDetails: JobDetails,
        val logo: String,
        val IsFeatured: Boolean,
        val minExperience: Int,
        val maxExperience: Int,
        val minSalary: String,
        val maxSalary: String
    ){
        data class JobDetails(
            val Title: String,
            val LastDate: String,
            val CompanyName: String,
            val ApplyInstruction: String,
        )
    }
}