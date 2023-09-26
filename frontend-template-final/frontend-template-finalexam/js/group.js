var listGroup=[];

$(function() {
    getAllGroup()
});

function getAllGroup() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8888/api/v1/groups",
        // data: "data",
        dataType: "JSON",
        success: function (response) {
            // noi cac duw lieu vao barng account
            listGroup=[];
            listGroup = response;
            for (let i = 0; i < listGroup.length; i++) {
                //noi vafo phan than cuar table account lan luont cac ptu trong list
                $("#tableAccount").append(
                    ` <tr>
                        <td>${listGroup[i].id}</td>
                        <td>${listGroup[i].groupName}</td>
                        <td>${listGroup[i].totalMember}</td>
                        <td>${listGroup[i].creatorUsername}</td>   
                        <td>${listGroup[i].creatorId}</td>
                        <td>${listGroup[i].createdDate}</td>
                    </tr>`
                );
                
            }
        }
    });
}

