package com.basaran.howmanypeopleinspace.data.remote.regres

import com.basaran.howmanypeopleinspace.model.PeopleModel

data class SpaceListResponse(
    var people: List<PeopleModel>,
    var message: String,
    var number: Int
)