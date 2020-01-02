package com.gst.pcp.best;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class newFaq extends AppCompatActivity{


    private GifImageView g;
    private com.gst.pcp.best.MovieCategoryAdapter mAdapter;
    private RecyclerView recyclerView;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfaq);

        g=(GifImageView)findViewById(R.id.gif);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(newFaq.this,QuestionForm.class);
                startActivity(intent);
            }
        });


        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        Movies  ans_one = new Movies("In terms of Section 2(30) of CGST Act, 2017, composite supply means a supply made by a taxable person to a recipient consisting of two or more taxable supplies of goods or services or both, or any combination thereof, which are naturally bundled and supplied in conjunction with each other in the ordinary course of business, one of which is a principal supply. The illustration of composite supply appended to Section 2(30) is as follows:\n" +
                "-\tWhere goods are packed and transported with insurance, the supply of goods, packing materials, transport and insurance is a composite supply and supply of goods is a principal supply.\n");
        Movies  ans_two  = new Movies("In terms of Section 8 of the CGST Act, 2017, tax liability in case of composite supply should be determined with reference to the principal supply forming part of such composite supply.");
        Movies  ans_three = new Movies("Notwithstanding anything to the contrary contained in the CGST Act but subject to the provisions of sections 9(3) and 9(4), a registered person, whose aggregate turnover in the preceding financial year did not exceed one crore rupees, may opt to pay, in lieu of the tax payable by him.\n" +
                "However, this limit, is rupees seventy-five lakhs in the case of an eligible registered person, registered under section 25 of the CGST Act, in any following States, namely: -\n" +
                "\n" +
                "(i) Arunachal Pradesh,\n" +
                "(ii) Assam,\n" +
                "(iii) Manipur,\n" +
                "\n" +
                "(iv) Meghalaya,\n" +
                "(v) Mizoram,\n" +
                "(vi) Nagaland,\n" +
                "(vii) Sikkim,\n" +
                "(viii) Tripura,\n" +
                "(ix) Himachal Pradesh\n" +
                "\n" +
                "It may be noted that aforesaid limit of Rs. 1 crore/ 75 lakh came from Notification No.46/2017- Central Tax dated 13.10.2017. Prior to such change the threshold limit were Rs. 75 and 50 lakh respectively as stated in Notification No. 8/2017-Central Tax dated 27.06.2017.\n");
        Movies ans_four  = new Movies("Section 10(1) of the CGST Act, 2017 prescribes, subject to such conditions and\n" +
                "restrictions as may be prescribed, that with effect from 1.1.2018, the rate of tax, shall not exceed:\n" +
                "\n" +
                "a)\t Half per cent of the turnover in State or turnover in Union territory in case of a\n" +
                "manufacturer;\n" +
                "\n" +
                "b) two and a half per cent, of the turnover in State or turnover in Union territory in\n" +
                "case of persons engaged in making supplies referred to in clause (b) of\n" +
                "paragraph 6 of Schedule II; and\n" +
                "\n" +
                "c) half per cent, of the turnover of taxable supplies of goods in State or turnover\n" +
                "in Union territory in case of other suppliers in terms of Notification No. 8/2017-Central Tax dated 27.06.2017 read with Notification No. 1/2018- Central Tax dated 1.1.2018.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "It may be noted that before 1.1.2018, the rates as per Notification No. 8/2017-Central Tax dated 27.06.2017 were:\n" +
                "\n" +
                "a. one per cent of the turnover in State or turnover in Union territory in case of a\n" +
                "manufacturer;\n" +
                "\n" +
                "b. two and a half per cent, of the turnover in State or turnover in Union territory in\n" +
                "case of persons engaged in making supplies referred to in clause (b) of paragraph 6 of Schedule II; and\n" +
                "\n" +
                "c. half per cent, of the turnover in State or turnover in Union territory in case of\n" +
                "other suppliers.\n ");
        Movies ans_five = new Movies("No, ‘Inputs’ are defined under Section 2(59) of the CGST Act to mean any goods other than capital goods used or intended to be used by a supplier in the course or furtherance of business.\n" +
                "\n" +
                "‘Capital goods’ are defined under Section 2(19) of the CGST Act, mean goods, the\n" +
                "value of which is capitalized in the books of account of the person claiming the input tax credit and which are used or intended to be used in the course or furtherance of business.\n" +
                "\n ");
        Movies ans_six = new Movies("Every supplier whose aggregate turnover exceeds ` 20 Lacs (10 Lacs for special\n" +
                "category States) in a financial year is liable to get himself registered in a State from\n" +
                "where he makes taxable supplies. However, certain categories of persons mentioned in Section 24 of GST Law are liable to be registered irrespective of this threshold.\n" +
                "\n");
        Movies ans_seven = new Movies("As per section 2 (6) of the GST Law, aggregate turnover means the aggregate value of all taxable supplies, exempt supplies, export of goods or services or both and inter- State supplies of persons having the same PAN, to be computed on all India basis and excludes CGST/SGST, IGST, UTGST and cess.\n" +
                "\n" +
                "Aggregate turnover does not include value of inward supplies on which tax is payable on reverse charge basis.\n");
        Movies ans_eight = new Movies("No. Every person will have to get registered separately for each of the State from where he makes taxable supply if he is liable for registration in terms of section 22(1) of the CGST Act.");
        Movies ans_nine = new Movies("Yes. As per proviso to Section 25(2) of the CGST Act, a person having multiple\n" +
                "business verticals in a State or Union territory, may obtain a separate registration for each business vertical, subject to such conditions as may be prescribed.\n");
        Movies ans_ten = new Movies("No, Cancellation of registration does not affect the tax liability of the person which is incurred prior to the date of cancellation. He shall still be liable to pay the amount of tax and other dues or any other obligation for a period prior to the date of cancellation irrespective of the fact that whether the same is determined before or after the cancellation of registration.\n" +
                "\n");


        com.gst.pcp.best.MovieCategory quest_one = new MovieCategory("What is composite supply?", Arrays.asList(ans_one));
        MovieCategory quest_two = new MovieCategory("How would the tax liability be determined in case of Composite supply?", Arrays.asList(ans_two));
        MovieCategory quest_three = new MovieCategory("What is the threshold limit for opting Composition scheme?", Arrays.asList(ans_three));
        MovieCategory quest_four = new MovieCategory("What is the rate of tax applicable to a taxable person opting to pay tax under" +
                "composition scheme?", Arrays.asList(ans_four));
        MovieCategory quest_five = new MovieCategory("Whether capital goods can be considered as inputs?", Arrays.asList(ans_five));
        MovieCategory quest_six = new MovieCategory("Who are the persons liable to take a Registration under the GST Law? or What is the " +
                "threshold limit for registration in case of GST?", Arrays.asList(ans_six));
        MovieCategory quest_seven = new MovieCategory("What is aggregate turnover?", Arrays.asList(ans_seven));
        MovieCategory quest_eight = new MovieCategory("If a person is operating in different States, with the same PAN number, can he operate with a single Registration?", Arrays.asList(ans_eight));
        MovieCategory quest_nine = new MovieCategory("Whether a person having multiple business verticals in a State or Union territory can obtain different registrations for each of such vertical?", Arrays.asList(ans_nine));
        MovieCategory quest_ten = new MovieCategory("Does cancellation of registration have any effect on the tax liability of the person whose registration has been cancelled?", Arrays.asList(ans_ten));

        final List<MovieCategory> movieCategories = Arrays.asList(quest_one, quest_two, quest_three,quest_four,quest_five,quest_six,quest_seven,quest_eight,quest_nine,quest_ten);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MovieCategoryAdapter(this, movieCategories);

        /*
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                MovieCategory expandedMovieCategory = movieCategories.get(position);

                String toastMsg = getResources().getString(R.string.expanded, expandedMovieCategory.getName());
                Toast.makeText(newFaq.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                MovieCategory collapsedMovieCategory = movieCategories.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedMovieCategory.getName());
                Toast.makeText(newFaq.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
*/
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }
}